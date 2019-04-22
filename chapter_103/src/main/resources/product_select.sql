select * from type as t
inner join product as p on p.type_id=t.id
where t.name='СЫР';

	select * from product as t
where lower(t.name) like '%мороженное%';

select * from product as t
where t.expired_date between current_date and current_date+30;

select * from product as t
order by t.price desc
limit 1;

select count(*) from type as t
inner join product as p on p.type_id=t.id
where t.name='СЫР';

select * from type as t
inner join product as p on p.type_id=t.id
where t.name='СЫР' or t.name='МОЛОКО'

select distinct t.name from type as t
inner join product as p on p.type_id=t.id
where p.cnt< 10 or p.cnt is null;

select * from type as t
inner join product as p on p.type_id=t.id;
