do $$ 
declare marca_nombre varchar := 'SUZUKI';
        marca_id int := 0;
        tipo_moto_id int := 0;
        tipo_auto_id int := 1;
        tipo_pickup_id int := 2;
        tipo_camion_id int := 3;

begin

    marca_id := (SELECT id FROM MARCA WHERE nombre = marca_nombre);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('AN 125',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('AX 100',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('BURGMAN 200A',tipo_moto_id,marca_id,'2019',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('DL',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('EN',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GIXXER',tipo_moto_id,marca_id,'2017',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GN 125',tipo_moto_id,marca_id,'2017',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GSX',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GSX-R',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GSX-S',tipo_moto_id,marca_id,'2017',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GW',tipo_moto_id,marca_id,'2013',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('LT-A 500',tipo_moto_id,marca_id,'2013',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('RM-Z',tipo_moto_id,marca_id,'2011',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('RMX',tipo_moto_id,marca_id,'2013',NULL);

   INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('SV',tipo_moto_id,marca_id,'2017',NULL);

    
end$$