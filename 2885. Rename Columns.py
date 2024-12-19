import pandas as pd

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    students['student_id'] = students['id']
    students['first_name'] = students['first']
    students['last_name'] = students['last']
    students['age_in_years'] = students['age']

    del students['id']
    del students['first']
    del students['last']
    del students['age']

    return students