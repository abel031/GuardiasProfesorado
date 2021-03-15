-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2021 a las 12:39:15
-- Versión del servidor: 5.7.27-log
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `guardiasprofesores`
--
CREATE DATABASE IF NOT EXISTS `guardiasprofesores` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `guardiasprofesores`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

DROP TABLE IF EXISTS `actividad`;
CREATE TABLE `actividad` (
  `num_actividad` int(10) NOT NULL,
  `num_tramo` int(10) NOT NULL,
  `num_grupo` int(10) NOT NULL,
  `num_aula` int(10) NOT NULL,
  `num_asignatura` int(10) NOT NULL,
  `num_profesor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
CREATE TABLE `asignatura` (
  `num_asignatura` int(10) NOT NULL,
  `abreviatura` varchar(20) DEFAULT NULL,
  `nombre` varchar(40) NOT NULL,
  `nivel` varchar(10) DEFAULT NULL,
  `codigo` varchar(20) NOT NULL,
  `curso` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

DROP TABLE IF EXISTS `aula`;
CREATE TABLE `aula` (
  `num_aula` int(10) NOT NULL,
  `abreviatura` varchar(20) DEFAULT NULL,
  `nombre` varchar(40) NOT NULL,
  `nivel` int(10) DEFAULT NULL,
  `codigo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

DROP TABLE IF EXISTS `grupo`;
CREATE TABLE `grupo` (
  `num_grupo` int(10) NOT NULL,
  `abreviatura` varchar(20) DEFAULT NULL,
  `nombre` varchar(40) NOT NULL,
  `codigo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guardia`
--

DROP TABLE IF EXISTS `guardia`;
CREATE TABLE `guardia` (
  `num_guardia` int(10) NOT NULL,
  `profesor_sustituto` int(10) NOT NULL,
  `actividad` int(10) NOT NULL,
  `tieneTrabajo` tinyint(1) NOT NULL,
  `tabajo` varchar(100) DEFAULT NULL,
  `dia` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE `profesor` (
  `num_profesor` int(10) NOT NULL,
  `abreviatura` varchar(20) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL,
  `nivel` varchar(20) NOT NULL,
  `codigo` int(20) NOT NULL,
  `grupo_tutoria` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramo_horario`
--

DROP TABLE IF EXISTS `tramo_horario`;
CREATE TABLE `tramo_horario` (
  `num_tramo` int(10) NOT NULL,
  `codigo` int(10) NOT NULL,
  `numero_dia` int(10) NOT NULL,
  `numero_hora` int(10) NOT NULL,
  `hora_inicio` time(6) NOT NULL,
  `hora_final` time(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `num_usuario` int(10) NOT NULL,
  `uauario` varchar(20) NOT NULL,
  `passwd` varchar(64) NOT NULL,
  `tupoUsuario` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`num_actividad`),
  ADD KEY `FK_tramo` (`num_tramo`),
  ADD KEY `FK_grupo` (`num_grupo`),
  ADD KEY `FK_aula` (`num_aula`),
  ADD KEY `FK_asignatura` (`num_asignatura`),
  ADD KEY `FK_profesor` (`num_profesor`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`num_asignatura`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`num_aula`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`num_grupo`);

--
-- Indices de la tabla `guardia`
--
ALTER TABLE `guardia`
  ADD PRIMARY KEY (`num_guardia`),
  ADD KEY `FK_actividad` (`actividad`),
  ADD KEY `fk_profesus` (`profesor_sustituto`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`num_profesor`),
  ADD KEY `FK_profesor_grupo` (`grupo_tutoria`);

--
-- Indices de la tabla `tramo_horario`
--
ALTER TABLE `tramo_horario`
  ADD PRIMARY KEY (`num_tramo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`num_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `num_actividad` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  MODIFY `num_asignatura` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `num_aula` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `num_grupo` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `guardia`
--
ALTER TABLE `guardia`
  MODIFY `num_guardia` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `num_profesor` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tramo_horario`
--
ALTER TABLE `tramo_horario`
  MODIFY `num_tramo` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `num_usuario` int(10) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `FK_asignatura` FOREIGN KEY (`num_asignatura`) REFERENCES `asignatura` (`num_asignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_aula` FOREIGN KEY (`num_aula`) REFERENCES `aula` (`num_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_grupo` FOREIGN KEY (`num_grupo`) REFERENCES `grupo` (`num_grupo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_profesor` FOREIGN KEY (`num_profesor`) REFERENCES `profesor` (`num_profesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tramo` FOREIGN KEY (`num_tramo`) REFERENCES `tramo_horario` (`num_tramo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `guardia`
--
ALTER TABLE `guardia`
  ADD CONSTRAINT `FK_actividad` FOREIGN KEY (`actividad`) REFERENCES `actividad` (`num_actividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_profesus` FOREIGN KEY (`profesor_sustituto`) REFERENCES `profesor` (`num_profesor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `FK_profesor_grupo` FOREIGN KEY (`grupo_tutoria`) REFERENCES `grupo` (`num_grupo`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
