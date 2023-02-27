SELECT a.player_name, team, "nonpenalty_xG", "xA",pos.position, 
("nonpenalty_xG"*points_per_goal)+("xA"*points_per_assist)+2 as total_points
FROM advanced_stats a JOIN player_positions p ON a.player_name = p.player_name JOIN points_per_position pos ON p.fpl_position=pos.position
WHERE pos.position='MID'
ORDER BY total_points DESC
LIMIT 5;

--select player_name, "xA" from advanced_stats
--WHERE pos.position='MID'