select c.car_id
from car_rental_company_car c
join car_rental_company_rental_history r on c.car_id = r.car_id
where month(start_date) = 10 and car_type = '세단'
group by c.car_id
order by c.car_id desc