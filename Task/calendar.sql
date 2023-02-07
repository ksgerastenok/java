SELECT
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 1 AS "MON",
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 2 AS "TUE",
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 3 AS "WED",
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 4 AS "THU",
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 5 AS "FRI",
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 6 AS "SAT",
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 7 AS "SUN"
FROM
  sys.dual
CONNECT BY
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 1 < trunc(trunc(sysdate, 'MM') + 35, 'MM');
