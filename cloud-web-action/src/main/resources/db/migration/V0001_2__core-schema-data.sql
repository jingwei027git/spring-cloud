-- ==================================================================
-- SAMPLE DATA
-- ==================================================================

-- SYS_USER
-- TRUNCATE sys_user;
INSERT INTO sys_user (
	ID, CREATE_USER, CREATE_TIME, MODIFY_USER, MODIFY_TIME, SYS_STATUS,
	USERNAME, FIRSTNAME, LASTNAME, EMAIL, DESCRIPTION,
	PASSWORD, EXPIRE_TIME)
VALUES (
	1, 'SYSTEM', SYSDATE(), 'SYSTEM', SYSDATE(), 'Y',
	'admin', NULL, NULL, 'admin@softpower.com.tw', NULL,
	'$2a$10$.mAivHSvvrO9MkQ77lGD5.WxVmj75qQG7dqcxzL2vRgr/IJOQmZqu', NULL
);