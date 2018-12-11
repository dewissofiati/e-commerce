CREATE TABLE konsumen(
  id_konsumen      character varying(64)     NOT NULL    PRIMARY KEY,
  nama_konsumen    character varying(100)    NOT NULL,
  alamat           character varying(255)    NOT NULL,
  kode_pos         character varying(64)     NOT NULL,
  kota             character varying(64),
  no_hp            character varying(64),
  email            character varying(100)
);

CREATE TABLE kategori(
  id_kategori      character varying(64)      NOT NULL     PRIMARY KEY,
  nama             character varying(100)     NOT NULL,
  deskripsi        character varying(255)     NOT NULL
);

CREATE TABLE toko(
  id_toko       character varying(64)     NOT NULL    PRIMARY KEY,
  nama_toko     character varying(100)    NOT NULL,
  nama_pemilik  character varying(100)    NOT NULL,
  alamat        character varying(255)    NOT NULL,
  kota          character varying(64)     NOT NULL,
  no_hp         character varying(64)     NOT NULL,
  kode_pos      character varying(100)    NOT NULL
);