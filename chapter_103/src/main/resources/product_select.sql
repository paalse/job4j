select * from type as t
inner join product as p on p.type_id=t.id
where t.name='СЫР';

	select * from product as t
where lower(t.name) like '%мороженное%';

select * from product as t
where t.expired_date between '2019-05-01 00:00:00' and '2019-06-01 00:00:00';

select * from product as t
order by t.price desc
limit 1;

select count(*) from type as t
inner join product as p on p.type_id=t.id
where t.name='СЫР';

select * from type as t
inner join product as p on p.type_id=t.id
where t.name='СЫР' or t.name='МОЛОКО'

select * from product p
where p.cnt < 10;

select * from type as t
inner join product as p on p.type_id=t.id;
