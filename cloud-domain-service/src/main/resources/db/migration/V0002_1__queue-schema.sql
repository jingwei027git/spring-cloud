-- ==================================================================
-- TABLES - MySQL
-- ==================================================================

-- SYS_QUEUE_LOG
-- DROP TABLE IF EXISTS `SYS_QUEUE_LOG`;
CREATE TABLE IF NOT EXISTS `SYS_QUEUE_LOG` (
	ID							BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	CREATE_USER					VARCHAR(50) NOT NULL,
	CREATE_TIME					DATETIME NOT NULL,
	MODIFY_USER					VARCHAR(50) NOT NULL,
	MODIFY_TIME					DATETIME NOT NULL,
	
	UUID						VARCHAR(50) NOT NULL,
	STATUS						VARCHAR(1) NOT NULL,
	CATEGORY					VARCHAR(25) NOT NULL,
	SEND_TIME					DATETIME,
	RECV_TIME					DATETIME,
	FINISH_TIME					DATETIME,
	COMMENT						VARCHAR(500)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;