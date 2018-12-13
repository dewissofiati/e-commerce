CREATE TABLE konfirmasi(
  id_konfirmasi         character varying(64)     NOT NULL    PRIMARY KEY,
  id_konsumen           character varying(64)     NOT NULL,
  id_detail_pemesanan   character varying(64)     NOT NULL,
  total                 int                       NOT NULL,
  id_pembayaran         character varying(64)     NOT NULL,
  atas_nama             character varying(64)     NOT NULL,
  tanggal_bayar         date                      NOT NULL,
  status_pembayaran     boolean                   NOT NULL
);

ALTER TABLE konfirmasi
add constraint fk_konfirmasi_konsumen foreign key (id_konsumen)
references konsumen (id_konsumen) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE konfirmasi
add constraint fk_konfirmasi_detail_pemesanan foreign key(id_detail_pemesanan)
references detail_pemesanan (id_detail_pemesanan) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE konfirmasi
add constraint fk_konfirmasi_pembayaran foreign key (id_pembayaran)
references pembayaran (id_pembayaran) ON UPDATE CASCADE ON DELETE RESTRICT;