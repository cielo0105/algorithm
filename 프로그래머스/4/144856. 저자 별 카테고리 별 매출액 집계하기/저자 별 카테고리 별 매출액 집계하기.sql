select a.author_id, a.author_name, category, sum(sales*price) as total_sales
from book b
join book_sales s on s.book_id = b.book_id
join author a on b.author_id = a.author_id
where s.sales_date like '2022-01%'
group by a.author_id, b.category
order by a.author_id, b.category desc