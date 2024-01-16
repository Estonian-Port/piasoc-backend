do $$ 
declare marca_nombre varchar := 'JEEP';
        marca_id int := 0;
        tipo_moto_id int := 0;
        tipo_auto_id int := 1;
        tipo_pickup_id int := 2;
        tipo_camion_id int := 3;

begin

    marca_id := (SELECT id FROM MARCA WHERE nombre = marca_nombre);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('CHEROKEE',tipo_auto_id,marca_id,'2000',NULL);

     INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('COMPASS',tipo_auto_id,marca_id,'2007',NULL);

     INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('GRAND CHEROKEE',tipo_auto_id,marca_id,'2000',NULL);

     INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('PATRIOT',tipo_auto_id,marca_id,'2009','2017');

     INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('RENEGADE',tipo_auto_id,marca_id,'2016',NULL);

     INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('WRANGLER',tipo_auto_id,marca_id,'2000',NULL);

 
end$$