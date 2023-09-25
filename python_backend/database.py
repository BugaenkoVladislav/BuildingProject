import psycopg2
from psycopg2.extensions import cursor


def get_available_material_pie_chart(cursor:cursor, project_id: int):
    result = cursor.execute(f"""select name from 
    available_material as am inner join material as m on am.id_material = m.id_material
    inner join material_category as mc on mc.id_material_category = m.id_material_category
    where am.id_project = {project_id}""")
    return result

def main():
    pass

if __name__ == '__main__':
    main()
