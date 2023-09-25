import plotly.express as px
import plotly.figure_factory as ff
import pandas as pd

def draw_available_material_pie_chart(df:pd.DataFrame):
    fig = px.pie(
        df,
        names='Material',
        values='Amount',
        title='Соотношение имеющихся материалов'
    )
    fig.update_traces(textposition='inside', textinfo='percent+label')
    return fig

def draw_work_gantt_chart(df:pd.DataFrame):
    fig = ff.create_gantt(
        df,
        colors='Blues',
        index_col='Complete',
        show_colorbar=True,
        bar_width=0.5,
        showgrid_x=True,
        showgrid_y=True
    )

    return fig

def main():
    df = pd.DataFrame([
                   ['Run', '2010-01-01', '2011-02-02', 10],
                   ['Fast', '2011-01-01', '2012-06-05', 55],
                   ['Eat', '2012-01-05', '2013-07-05', 5]],
                  columns=['Task', 'Start', 'Finish', 'Complete'])

    fig = draw_work_gantt_chart(df)
    fig.write_html('first_figure.html', auto_open=True)

if __name__ == "__main__":
    main()
