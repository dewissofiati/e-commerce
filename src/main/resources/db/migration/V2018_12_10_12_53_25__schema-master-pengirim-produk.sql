CREATE TABLE pengirim(
  id_pengirim       character varying(64)     NOT NULL    PRIMARY KEY,
  nama_pengirim     character varying(100)    NOT NULL,
  no_hp             character varying(64)     NOT NULL
);

CREATE TABLE produk(
  id_produk        character varying(64)       NOT NULL     PRIMARY KEY,
nama             character varying(100)      NOT NULL,
harga            INT                         NOT NULL,
kuantiti         INT,
id_kategori      character varying(64)       NOT NULL,
id_toko          character varying(64)       NOT NULL
);

ALTER TABLE produk
ADD CONSTRAINT fk_kategori_produk FOREIGN KEY (id_kategori)
REFERENCES kategori (id_kategori) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE produk
ADD CONSTRAINT fk_toko_produk FOREIGN KEY (id_toko)
REFERENCES toko (id_toko) ON UPDATE CASCADE ON DELETE RESTRICT;

CREATE TABLE kategori_produk(
  id_produk       character varying     NOT NULL,
  id_kategori     character varying     NOT NULL
);

ALTER TABLE kategori_produk
add constraint fk_kategori_produk_id foreign KEY (id_produk)
references produk (id_produk) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE kategori_produk
add constraint fk_kategori_produk_kategori_id foreign KEY(id_kategori)
references kategori (id_kategori) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE kategori_produk
add constraint uq_kategori_produk unique(id_produk, id_kategori);