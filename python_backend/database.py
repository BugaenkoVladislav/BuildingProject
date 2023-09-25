from psycopg2.extensions import cursor


def select_available_material(cursor:cursor, project_id: int):
    cursor.execute(f"""
    select m.name as material, am.count as count, m.unit as unit, mc.name as category from 
    available_material as am inner join material as m on am.id_material = m.id_material
    inner join material_category as mc on mc.id_material_category = m.id_material_category
    where am.id_project = {project_id}
    """)
    result = cursor.fetchall()
    return result

def select_work(cursor:cursor, project_id: int):
    cursor.execute(f"""
    select name as task, expected_date_start, expected_date_end, 
    extract(day FROM age(expected_date_end, expected_date_start)) as days_count 
    from work where id_project = {project_id}""")
    result = cursor.fetchall()
    return result

def main():
    pass

if __name__ == '__main__':
    main()
