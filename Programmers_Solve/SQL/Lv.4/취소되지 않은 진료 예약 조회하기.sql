-- 취소되지 않은 진료 예약 조회하기
SELECT APNT_NO, PT_NAME, apt_dct.PT_NO, MCDP_CD, DR_NAME, APNT_YMD
FROM (SELECT 
        apt.APNT_YMD, apt.APNT_NO, apt.PT_NO, apt.MCDP_CD, apt.MDDR_ID, apt.APNT_CNCL_YN, dct.DR_NAME
    FROM APPOINTMENT apt
    JOIN DOCTOR dct
    ON dct.DR_ID = apt.MDDR_ID) AS apt_dct
JOIN PATIENT ptn
ON ptn.PT_NO = apt_dct.PT_NO
WHERE apt_dct.APNT_CNCL_YN = 'N' AND (DATE(apt_dct.APNT_YMD) = '2022-04-13')
ORDER BY apt_dct.APNT_YMD ASC;