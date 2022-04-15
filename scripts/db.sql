create table kategori(
	id serial primary key,
	isim varchar(30)
);

create table urun(
	id serial primary key,
	kategori_id int,
	isim varchar(30),
	fiyat int,
	stok int,
	constraint kategori_fk foreign key (kategori_id) references kategori(id)
);

create table musteri(
	id serial primary key,
	isim varchar(30),
	soyisim varchar(30),
	tlf varchar(30)
);

create table satis(
	id serial primary key,
	urun_id int,
	musteri_id int,
	satistarihi varchar(30),
	constraint urun_fk foreign key (urun_id) references urun(id),
	constraint musteri_fk foreign key (musteri_id) references musteri(id)
);