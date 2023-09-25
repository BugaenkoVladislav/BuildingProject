from fastapi import FastAPI
import uvicorn
import pandas as pd
import psycopg2

import database as db
import plots_drawing
import config

app = FastAPI()


@app.get("/available_material_pie_chart/{project_id}")
async def get_available_material_pie_chart_html(project_id: int):
    available_material = db.get_available_material_pie_chart(cursor, project_id)
    df = pd.DataFrame(available_material, columns=[
        'Material', 'Amount', 'Unit', 'Category'])
    pie_chart = plots_drawing.draw_available_material_pie_chart(df)
    pie_chart_html = pie_chart.to_html()
    return pie_chart_html

if __name__ == "__main__":
    try:
        connection = psycopg2.connect(
            database=config.db_name,
            user=config.db_user,
            password=config.db_password,
            host=config.host,
            port=config.db_port
        )
        cursor = connection.cursor()

        uvicorn.run('main:app', host='127.0.0.1', port=8080, reload=True)
    except Exception as e:
        print(e)
    finally:
        if connection:
            connection.close()
        if cursor:
            cursor.close()
