-- 코드를 입력하세요
SELECT year(sales_date) year, month(sales_date) month, gender, count(distinct(u.user_id)) users
from user_info u
join online_sale o on u.user_id = o.user_id
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year, month, gender