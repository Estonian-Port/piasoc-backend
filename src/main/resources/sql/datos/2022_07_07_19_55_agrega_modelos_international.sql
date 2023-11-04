do $$ 
declare marca_nombre varchar := 'INTERNATIONAL';
        marca_id int := 0;
        tipo_moto_id int := 0;
        tipo_auto_id int := 1;
        tipo_pickup_id int := 2;
        tipo_camion_id int := 3;

begin

    marca_id := (SELECT id FROM MARCA WHERE nombre = marca_nombre);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('2654X202',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('2654X224',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('4700X170',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('4700X206',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('4900X176',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('4900X206',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('4900X218',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('8200X196',tipo_camion_id,marca_id,'2000','2000');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('9800 SFA',tipo_camion_id,marca_id,'2000','2001');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('9800X152',tipo_camion_id,marca_id,'2000','2003');

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('9800X156',tipo_camion_id,marca_id,'2000','2003');


     
end$$