CREATE TABLE pembayaran(
  id_pembayaran     character varying(64)     NOT NULL      PRIMARY KEY,
  metode_pembayaran character varying(100)    NOT NULL,
  biaya_penanganan  int                       NOT NULL,
  deskripsi         character varying(255)    NOT NULL
);

CREATE TABLE pemesanan(
  id_pemesanan  character varying(64) NOT NULL PRIMARY KEY,
  id_konsumen   character varying(64) NOT NULL,
  id_produk     character varying(64) NOT NULL,
  id_toko       character varying(64) NOT NULL,
  jumlah        int                   NOT NULL,
  harga         int                   NOT NULL,
  total         int                   NOT NULL
);

ALTER TABLE pemesanan
ADD constraint fk_pemesanan_konsumen foreign KEY(id_konsumen)
references konsumen(id_konsumen) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE pemesanan
ADD constraint fk_pemesanan_produk foreign KEY(id_produk)
references produk(id_produk) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE pemesanan
ADD constraint fk_pemesanan_toko foreign KEY(id_toko)
references toko(id_toko) ON UPDATE CASCADE ON DELETE RESTRICT;