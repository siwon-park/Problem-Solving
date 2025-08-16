from datetime import datetime

# 오늘의 날짜는?
date_now = datetime.now().strftime("%Y-%m-%d")
date_now = date_now.split("-")
year = date_now[0]
month = date_now[1]
day = date_now[2]
print(year)
print(month)
print(day)
