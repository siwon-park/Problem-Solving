-- 특정 물고기를 잡은 총 수 구하기
SELECT COUNT(fi.id) AS 'FISH_COUNT'
FROM fish_info fi
JOIN fish_name_info fni
ON fi.fish_type = fni.fish_type
WHERE fni.fish_name = 'BASS' OR fni.fish_name = 'SNAPPER';
