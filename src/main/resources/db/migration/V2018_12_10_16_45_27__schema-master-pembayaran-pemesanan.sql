CREATE TABLE pembayaran(
  id_pembayaran   character varying(64)     NOT NULL      PRIMARY KEY,
  metode_pembayaran character varying(100)    NOT NULL,
  deskripsi       character varying(255)    NOT NULL
);

CREATE TABLE pemesanan(
  id_pemesanan  character varying(64) NOT NULL PRIMARY KEY,
  id_konsumen   character varying(64) NOT NULL,
  tanggal_pesan date                  NOT NULL,
  status_pembayaran  boolean               NOT NULL,
  total_bayar   int                   NOT NULL,
  id_pengirim   character varying(64) NOT NULL,
  id_pembayaran character varying(64) NOT NULL
);

ALTER TABLE pemesanan
ADD constraint fk_konsumen_pemesanan foreign KEY(id_konsumen)
references konsumen(id_konsumen) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE pemesanan
ADD constraint fk_pengirim_pemesanan foreign KEY(id_pengirim)
references pengirim(id_pengirim) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE pemesanan
ADD constraint fk_pembayaran_pemesanan foreign KEY(id_pembayaran)
references pembayaran(id_pembayaran) ON UPDATE CASCADE ON DELETE RESTRICT;