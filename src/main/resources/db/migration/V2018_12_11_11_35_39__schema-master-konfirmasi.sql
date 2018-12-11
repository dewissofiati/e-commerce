CREATE TABLE konfirmasi(
  id_konfirmasi         character varying(64)     NOT NULL    PRIMARY KEY,
  id_pemesanan          character varying(64)     NOT NULL,
  id_konsumen           character varying(64)     NOT NULL,
  total_tagihan         int                       NOT NULL,
  id_pembayaran         character varying(64)     NOT NULL,
  no_rekening           character varying(64)     NOT NULL,
  rekening_atas_nama    character varying(64)     NOT NULL,
  tanggal_transfer      date                      NOT NULL,
  status_pembayaran     boolean                   NOT NULL
);

ALTER TABLE konfirmasi
add constraint fk_konfirmasi_pemesanan foreign key(id_pemesanan)
references pemesanan (id_pemesanan) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE konfirmasi
add constraint fk_konfirmasi_konsumen foreign key (id_konsumen)
references konsumen (id_konsumen) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE konfirmasi
add constraint fk_konfirmasi_pembayaran foreign key (id_pembayaran)
references pembayaran (id_pembayaran) ON UPDATE CASCADE ON DELETE RESTRICT;