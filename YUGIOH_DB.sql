PGDMP     8                	    z         	   YUGIOH_DB    10.22    10.22     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    65583 	   YUGIOH_DB    DATABASE     �   CREATE DATABASE "YUGIOH_DB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
    DROP DATABASE "YUGIOH_DB";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    73740    hechizos    TABLE     �   CREATE TABLE public.hechizos (
    id_carta integer NOT NULL,
    nombre character varying(40) NOT NULL,
    descripcion character varying(500) NOT NULL,
    imagen_url character varying(300) NOT NULL
);
    DROP TABLE public.hechizos;
       public         postgres    false    3            �            1259    65592 	   monstruos    TABLE       CREATE TABLE public.monstruos (
    id_carta integer NOT NULL,
    nombre character varying(40) NOT NULL,
    descripcion character varying(200) NOT NULL,
    imagen_url character varying(250) NOT NULL,
    ataque integer NOT NULL,
    defensa integer NOT NULL
);
    DROP TABLE public.monstruos;
       public         postgres    false    3            �
          0    73740    hechizos 
   TABLE DATA               M   COPY public.hechizos (id_carta, nombre, descripcion, imagen_url) FROM stdin;
    public       postgres    false    197   W       �
          0    65592 	   monstruos 
   TABLE DATA               _   COPY public.monstruos (id_carta, nombre, descripcion, imagen_url, ataque, defensa) FROM stdin;
    public       postgres    false    196   I       t
           2606    73744    hechizos hechizos_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.hechizos
    ADD CONSTRAINT hechizos_pkey PRIMARY KEY (id_carta);
 @   ALTER TABLE ONLY public.hechizos DROP CONSTRAINT hechizos_pkey;
       public         postgres    false    197            r
           2606    65596    monstruos monstruos_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.monstruos
    ADD CONSTRAINT monstruos_pkey PRIMARY KEY (id_carta);
 B   ALTER TABLE ONLY public.monstruos DROP CONSTRAINT monstruos_pkey;
       public         postgres    false    196            �
   �  x���M��0����z)����P�@]�"T�R4�'����?
�ׯ�~nŁ��2�����}���lsR
�Z"!�����`SE�[0�L��գ�Zt�
胇)�ʹ	ړ�c� �2���R3o��7��n��F��`~��7G�1�I����ᡋC����C�{|_>�V�:�Y����Y��\���a)W�+��9J�-�V�5�+骎���t���oΒ?jj���%�^v��z^�7 X�̖4�t�+�AD���
��!���t�·q;���{Ku�*�E;?e<�:�pώ F��k�/rVe`�	X5��0o�0�7]-5z_}�#���"#h$)q���C����G��<�gA�'x�w����@�hVD��	�M�Ƈ�t�~T�;�hK*E;.e�06�C��?����@8�>/�`/���n���w����1V5j�ڋ�����=��?�h#���?����joq5��I`��p�a ��      �
   s  x���ώ� ���)��:"���-J�����"!Y�Z[6��؎�o�|���7k��_���u���&���Cq �{�4� ��h�����.DB�+�.0rZ��R�#)ՠ˝R�C�􉕳M?r����y���\���dE�cP��4���l/�R���C�b�]LVr���֋������F��k�d�0F��2j��p���O���F���ܛ�8Q%�`��!$��Jn�')�b+�H'n�n��v��P�.���_���F�\@����:��H�	eq[�m5��9���ġ�-������'����:��,�MĄ<Pzz1�-�]��1����L����J��g�g�HjU�BL�     