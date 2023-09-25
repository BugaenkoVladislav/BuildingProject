from fastapi import FastAPI
import uvicorn
import pandas as pd
import psycopg2

import database as db
import plots_drawing
import config

app = FastAPI()

connection = psycopg2.connect(
            database=config.db_name,
            user=config.db_user,
            password=config.db_password,
            host=config.host,
            port=config.db_port
        )
cursor = connection.cursor()

def cut_html_tag(html: str) -> str:
    html = html[html.find('</head>')+8:]
    html = html[:-8]
    return html

@app.get("/available_material_pie_chart/{project_id}")
async def get_available_material_pie_chart_html(project_id: int):
    available_material = db.select_available_material(cursor, project_id)
    df = pd.DataFrame(available_material, columns=[
        'Материал', 'Количество', 'Единицы измерения', 'Категория'])
    pie_chart = plots_drawing.draw_available_material_pie_chart(df)
    pie_chart_html = cut_html_tag(pie_chart.to_html())
    return pie_chart_html

@app.get("/work_gantt_chart/{project_id}")
async def get_work_gantt_chart(project_id: int):
    work = db.select_work(cursor, project_id)
    df = pd.DataFrame(work, columns=[
        'Task', 'Start', 'Finish', 'Complete'])
    df['Complete'] = df['Complete'].astype(float)
    gantt_chart = plots_drawing.draw_work_gantt_chart(df)
    gantt_chart_html = cut_html_tag(gantt_chart.to_html())
    return gantt_chart_html

if __name__ == "__main__":
    try:
        uvicorn.run('main:app',
                    host=config.host,
                    port=config.server_port,
                    reload=True)
    except Exception as e:
        print(e)
    finally:
        if connection:
            connection.close()
        if cursor:
            cursor.close()
