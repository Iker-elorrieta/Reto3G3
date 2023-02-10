-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-02-2023 a las 09:18:26
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reto3_grupo3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `Código_Cine` varchar(6) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`Código_Cine`, `Nombre`, `Direccion`) VALUES
('C001', 'Cine Elorrieta', 'Agirre Lehendakariaren Etorb., 184, 48015 Bilbo, Bizkaia'),
('C002', 'Roxy Valladolid', 'C. María de Molina, 20, 47001 Valladolid'),
('C003', 'Cinesa Zaratán Valladolid', 'Autovía Valladolid-León, N-601, km 3, 47610 Zaratán, Valladolid'),
('C004', 'Cinesa Max Ocio Barakaldo Vizcaya', 'Barrio, Kareaga Kalea, S/N, 48903 Barakaldo, Biscay');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(40) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Contra` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`DNI`, `Nombre`, `Apellido`, `Sexo`, `Contra`) VALUES
('22761890D', 'Ander', 'de la Iglesia', 'H', 'Aduriz'),
('45919503A', 'Samuel', 'Sainz-Terrones', 'H', 'Muniain'),
('68725924L', 'Peio', 'Hernando', 'H', 'Peio1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `Código_Entrada` varchar(6) NOT NULL,
  `Precio` float NOT NULL,
  `Código_Sesión` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`Código_Entrada`, `Precio`, `Código_Sesión`) VALUES
('E001', 6.5, 'SE05'),
('E002', 6.5, 'SE05'),
('E003', 6.5, 'SE12'),
('E004', 6.5, 'SE09'),
('E005', 6.5, 'SE09'),
('E006', 6.5, 'SE27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `Código_Pedido` varchar(6) NOT NULL,
  `Importe` float NOT NULL,
  `Fecha_Compra` date NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Código_Entrada` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `películas`
--

CREATE TABLE `películas` (
  `Código_Película` varchar(6) NOT NULL,
  `Duración` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Género` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `películas`
--

INSERT INTO `películas` (`Código_Película`, `Duración`, `Nombre`, `Género`) VALUES
('C001', 90, 'Scary movie', 'Comedia'),
('C002', 119, 'El gran Lebowsky', 'Comedia'),
('C003', 94, 'La vida de Brian', 'Comedia'),
('C004', 88, 'Aterriza como puedas', 'Comedia'),
('CF001', 142, '2001: Odisea en el espacio', 'Ciencia ficción'),
('CF002', 75, 'La novia de Frankenstein', 'Ciencia ficción'),
('CF003', 115, 'El planeta de los simios', 'Ciencia ficción'),
('CF004', 117, 'Alien, el octavo pasajero', 'Ciencia ficción'),
('D001', 116, 'Handia', 'Drama'),
('D002', 197, 'La lista de Schindler', 'Drama'),
('D003', 142, 'Cadena Perpetua', 'Drama'),
('D004', 133, 'Million Dollar Baby', 'Drama'),
('T001', 109, 'Psicosis', 'Terror'),
('T002', 146, 'El resplandor', 'Terror'),
('T003', 155, 'Drácula', 'Terror'),
('T004', 110, 'Cisne negro', 'Terror');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `Código_Sala` varchar(6) NOT NULL,
  `Numero` tinyint(4) NOT NULL,
  `Código_Cine` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`Código_Sala`, `Numero`, `Código_Cine`) VALUES
('S001', 1, 'C001'),
('S002', 2, 'C001'),
('S003', 3, 'C001'),
('S004', 4, 'C001'),
('S005', 1, 'C002'),
('S006', 2, 'C002'),
('S007', 3, 'C002'),
('S008', 4, 'C002'),
('S009', 1, 'C003'),
('S010', 2, 'C003'),
('S011', 3, 'C003'),
('S012', 4, 'C003'),
('S013', 1, 'C004'),
('S014', 2, 'C004'),
('S015', 3, 'C004'),
('S016', 4, 'C004');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesión`
--

CREATE TABLE `sesión` (
  `Código_Sesión` varchar(6) NOT NULL,
  `Hora` time NOT NULL,
  `Fecha_Inicio` date NOT NULL,
  `Fecha_Fin` date NOT NULL,
  `Código_Película` varchar(6) NOT NULL,
  `Código_Sala` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sesión`
--

INSERT INTO `sesión` (`Código_Sesión`, `Hora`, `Fecha_Inicio`, `Fecha_Fin`, `Código_Película`, `Código_Sala`) VALUES
('SE01', '16:00:00', '2023-03-01', '2023-03-31', 'D001', 'S001'),
('SE02', '20:00:00', '2023-03-01', '2023-03-31', 'D001', 'S001'),
('SE03', '16:00:00', '2023-03-01', '2023-03-31', 'C001', 'S002'),
('SE04', '20:00:00', '2023-03-01', '2023-03-31', 'C001', 'S002'),
('SE05', '16:00:00', '2023-03-01', '2023-03-31', 'CF001', 'S003'),
('SE06', '20:00:00', '2023-03-01', '2023-03-31', 'CF001', 'S003'),
('SE07', '16:00:00', '2023-03-01', '2023-03-31', 'T001', 'S004'),
('SE08', '20:00:00', '2023-03-01', '2023-03-31', 'T001', 'S004'),
('SE09', '16:00:00', '2023-03-01', '2023-03-31', 'D002', 'S005'),
('SE10', '20:00:00', '2023-03-01', '2023-03-31', 'D002', 'S005'),
('SE11', '16:00:00', '2023-03-01', '2023-03-31', 'C002', 'S006'),
('SE12', '20:00:00', '2023-03-01', '2023-03-31', 'C002', 'S006'),
('SE13', '16:00:00', '2023-03-01', '2023-03-31', 'CF002', 'S007'),
('SE14', '20:00:00', '2023-03-01', '2023-03-31', 'CF002', 'S007'),
('SE15', '16:00:00', '2023-03-01', '2023-03-31', 'T002', 'S008'),
('SE16', '20:00:00', '2023-03-01', '2023-03-31', 'T002', 'S008'),
('SE17', '16:00:00', '2023-03-01', '2023-03-31', 'D003', 'S009'),
('SE18', '20:00:00', '2023-03-01', '2023-03-31', 'D003', 'S009'),
('SE19', '16:00:00', '2023-03-01', '2023-03-31', 'C003', 'S010'),
('SE20', '20:00:00', '2023-03-01', '2023-03-31', 'C003', 'S010'),
('SE21', '16:00:00', '2023-03-01', '2023-03-31', 'CF003', 'S011'),
('SE22', '20:00:00', '2023-03-01', '2023-03-31', 'CF003', 'S011'),
('SE23', '16:00:00', '2023-03-01', '2023-03-31', 'T003', 'S012'),
('SE24', '20:00:00', '2023-03-01', '2023-03-31', 'T003', 'S012'),
('SE25', '16:00:00', '2023-03-01', '2023-03-31', 'D004', 'S013'),
('SE26', '20:00:00', '2023-03-01', '2023-03-31', 'D004', 'S013'),
('SE27', '16:00:00', '2023-03-01', '2023-03-31', 'C004', 'S014'),
('SE28', '20:00:00', '2023-03-01', '2023-03-31', 'C004', 'S014'),
('SE29', '16:00:00', '2023-03-01', '2023-03-31', 'CF004', 'S015'),
('SE30', '20:00:00', '2023-03-01', '2023-03-31', 'CF004', 'S015'),
('SE31', '16:00:00', '2023-03-01', '2023-03-31', 'T004', 'S016'),
('SE32', '20:00:00', '2023-03-01', '2023-03-31', 'T004', 'S016');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`Código_Cine`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`Código_Entrada`),
  ADD KEY `fk_Cod_Sesión` (`Código_Sesión`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD KEY `fk_DNI` (`DNI`),
  ADD KEY `fk_Código_Entrada` (`Código_Entrada`);

--
-- Indices de la tabla `películas`
--
ALTER TABLE `películas`
  ADD PRIMARY KEY (`Código_Película`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`Código_Sala`),
  ADD KEY `fk_Cod_Cine` (`Código_Cine`);

--
-- Indices de la tabla `sesión`
--
ALTER TABLE `sesión`
  ADD PRIMARY KEY (`Código_Sesión`),
  ADD KEY `fk_Cod_Película` (`Código_Película`),
  ADD KEY `fk_Cod_Sala` (`Código_Sala`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `fk_Cod_Sesión` FOREIGN KEY (`Código_Sesión`) REFERENCES `sesión` (`Código_Sesión`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_Código_Entrada` FOREIGN KEY (`Código_Entrada`) REFERENCES `entrada` (`Código_Entrada`),
  ADD CONSTRAINT `fk_DNI` FOREIGN KEY (`DNI`) REFERENCES `clientes` (`DNI`);

--
-- Filtros para la tabla `salas`
--
ALTER TABLE `salas`
  ADD CONSTRAINT `fk_Cod_Cine` FOREIGN KEY (`Código_Cine`) REFERENCES `cine` (`Código_Cine`);

--
-- Filtros para la tabla `sesión`
--
ALTER TABLE `sesión`
  ADD CONSTRAINT `fk_Cod_Película` FOREIGN KEY (`Código_Película`) REFERENCES `películas` (`Código_Película`),
  ADD CONSTRAINT `fk_Cod_Sala` FOREIGN KEY (`Código_Sala`) REFERENCES `salas` (`Código_Sala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
