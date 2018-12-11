CREATE TABLE detail_pemesanan(
  id_detail_pemesanan   character varying(64)     NOT NULL    PRIMARY KEY,
  id_pemesanan          character varying(64)     NOT NULL,
  id_produk             character varying(64)     NOT NULL,
  kuantiti              int                       NOT NULL,
  harga                 int                       NOT NULL,
  total                 int                       NOT NULL
);

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_pemesanan foreign KEY(id_pemesanan)
references pemesanan(id_pemesanan) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_produk foreign KEY(id_produk)
references produk(id_produk) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE detail_pemesanan
ADD constraint un_detail_pemesanan unique (id_produk, id_pemesanan);