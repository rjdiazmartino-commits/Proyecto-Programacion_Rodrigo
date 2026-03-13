USE polideportivo;
-- usuarios por polideportivo
SELECT P.id_polideportivo, COUNT(*) AS usuarios
FROM reserva R
INNER JOIN usuario_reserva UR ON R.id_reserva = UR.id_reserva
INNER JOIN pista P ON P.id_pista = R.id_pista
GROUP BY P.id_polideportivo;

-- media de usuarios por polideportivo
SELECT AVG(usuarios) AS media_usuarios
FROM (
    SELECT P.id_polideportivo, COUNT(*) AS usuarios
    FROM reserva R
    INNER JOIN usuario_reserva UR ON R.id_reserva = UR.id_reserva
    INNER JOIN pista P ON P.id_pista = R.id_pista
    GROUP BY P.id_polideportivo
);

-- Query Final
select p.nombre
from polideportivo p,
(SELECT P.id_polideportivo, COUNT(*) AS usuarios
FROM reserva R
INNER JOIN usuario_reserva UR ON R.id_reserva = UR.id_reserva
INNER JOIN pista P ON P.id_pista = R.id_pista
GROUP BY P.id_polideportivo) UT;
(SELECT AVG(usuarios) AS media_usuarios
FROM (
    SELECT P.id_polideportivo, COUNT(*) AS usuarios
    FROM reserva R
    INNER JOIN usuario_reserva UR ON R.id_reserva = UR.id_reserva
    INNER JOIN pista P ON P.id_pista = R.id_pista
    GROUP BY P.id_polideportivo) UM)
WHERE UT.TOTAL >= UM.MEDIA