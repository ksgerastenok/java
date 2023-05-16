SELECT
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 1 AS "MON",
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 2 AS "TUE",
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 3 AS "WED",
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 4 AS "THU",
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 5 AS "FRI",
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 6 AS "SAT",
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 7 AS "SUN"
FROM
  sys.dual
CONNECT BY
  trunc(trunc(sysdate, 'MM'), 'DY') + 7 * (LEVEL - 1) + 1 < trunc(trunc(sysdate, 'MM') + 35, 'DY');
