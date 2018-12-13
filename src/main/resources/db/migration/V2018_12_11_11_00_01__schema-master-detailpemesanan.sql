CREATE TABLE detail_pemesanan(
  id_detail_pemesanan   character varying(64)     NOT NULL    PRIMARY KEY,
  id_pemesanan          character varying(64)     NOT NULL,
  id_produk             character varying(64)     NOT NULL,
  id_toko               character varying(64)     NOT NULL,
  jumlah                int                       NOT NULL,
  harga                 int                       NOT NULL,
  ongkir                int                       NOT NULL,
  id_pengirim           character varying(64)     NOT NULL,
  id_pembayaran         character varying(64)     NOT NULL,
  total                 int                       NOT NULL,
  status_pembayaran     boolean                   NOT NULL
);

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_pemesanan foreign KEY(id_pemesanan)
references pemesanan(id_pemesanan) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_produk foreign KEY(id_produk)
references produk(id_produk) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_toko foreign KEY (id_toko)
references toko(id_toko) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_pengirim foreign KEY (id_pengirim)
references pengirim(id_pengirim) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE detail_pemesanan
ADD constraint fk_detail_pemesanan_pembayaran foreign KEY (id_pembayaran)
references pembayaran(id_pembayaran) ON UPDATE CASCADE ON DELETE RESTRICT;