import plotly.express as px
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

def main():
    pass

if __name__ == "__main__":
    main()
