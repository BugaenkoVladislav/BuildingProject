import plotly.express as px
import plotly.figure_factory as ff
import pandas as pd

def draw_available_material_pie_chart(df:pd.DataFrame):
    fig = px.pie(
        df,
        names='Материал',
        values='Количество',
        title='Соотношение имеющихся материалов',
        hole=0.5,
    )
    fig.update_traces(
        textposition='inside',
        textinfo='percent+label',
        hoverinfo='label+percent',
        textfont_size=20,
        marker=dict(colors=['gold', 'mediumturquoise', 'darkorange', 'lightgreen'],
                    line=dict(color='#000000', width=2))
    )
    return fig

def draw_work_gantt_chart(df:pd.DataFrame):
    fig = ff.create_gantt(
        df,
        colors='Plotly3',
        index_col='Complete',
        show_colorbar=False,
        bar_width=0.5,
        showgrid_x=True,
        showgrid_y=True,
        group_tasks=True,
        title='Сроки работ',
    )
    fig.update_layout(
        title='Project Timeline',
        xaxis_title='Время',
        yaxis_title='Работы',
        font=dict(family='Arial', size=15),
    )
    fig.update_yaxes(autorange="reversed")

    return fig

def main():
    df_gantt = pd.DataFrame([
                   ['Run', '2010-01-01', '2011-02-02', 10],
                   ['Fast', '2011-01-01', '2012-06-05', 55],
                   ['Eat', '2012-01-05', '2013-07-05', 5]],
                  columns=['Task', 'Start', 'Finish', 'Complete'])

    df_pie = pd.DataFrame([
        ['Цемент', '5', 'Литров', 'Клей'],
        ['Щебень', '3', 'Кг', 'Укладка'],
        ['Обои', '10', 'Метров', 'Дизайн']],
        columns=['Материал', 'Количество', 'Единицы', 'Категория']
    )

    # fig = draw_available_material_pie_chart(df_pie)
    # fig.write_html('pie_chart.html', auto_open=True)

    fig = draw_work_gantt_chart(df_gantt)
    fig.write_html('gantt_chart.html', auto_open=True)

if __name__ == "__main__":
    main()
