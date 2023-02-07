SELECT
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 1, 'DD.MM.YYYY') AS "MON",
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 2, 'DD.MM.YYYY') AS "TUE",
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 3, 'DD.MM.YYYY') AS "WED",
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 4, 'DD.MM.YYYY') AS "THU",
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 5, 'DD.MM.YYYY') AS "FRI",
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 6, 'DD.MM.YYYY') AS "SAT",
  to_char(trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 7, 'DD.MM.YYYY') AS "SUN"
FROM
  sys.dual
CONNECT BY
  trunc(sysdate, 'MM') - to_number(to_char(trunc(sysdate, 'MM'), 'D')) + 7 * (LEVEL - 1) + 1 < trunc(trunc(sysdate, 'MM') + 35, 'MM');
