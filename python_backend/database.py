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
    select w.expected_date_start as start_date, w.expected_date_end as end_date,
     e.name as executor, s.name as work_scope, ws.name as work_status
     from 
    work as w inner join executor as e on w.id_executor = e.id_executor
    inner join scope_of_work as s on w.id_scope_of_work = s.id_scope_of_work
    inner join work_status as ws on w.id_work_status = ws.id_work_status
    where w.id_project = {project_id}
    """)
    result = cursor.fetchall()
    return result

def main():
    pass

if __name__ == '__main__':
    main()
