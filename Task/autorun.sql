select
  t.listid,
  t.state,
  0,
  t.restcount,
  t.state,
  {0}
from
(
  select
    t.id as listid,
    t.state as state,
    t.action as action,
    t.branchno as branchno,
    t.restcount as restcount,
    decode(t.division, 6, '��184(����������)', 12, '�������(����������)', 2, '�������(��������)', 3, '�190(��������)', 5, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'), 4, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)')) as lsttype,
    nvl(((sum(decode(t.action, 0,           1, 0)) over(partition by decode(t.division, 6, '��184(����������)', 12, '�������(����������)', 2, '�������(��������)', 3, '�190(��������)', 5, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'), 4, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)')) order by decode(t.state, 0, decode(t.userlogin, '*', 0, 1), 1, 3, 3, 1, t.state) asc, t.opdaybegin asc, t.listtype asc, t.id asc)) + (sum(decode(t.action, 0, 0,           1)) over())) /    1, 0) as cntwrk
  from
    offcash.depolist t
  where
  (
    ((t.flowday) in ((to_date('{1}', 'DD.MM.YYYY')))) and
    ((t.division) in ((2), (3), (4), (5), (6), (12))) and
    (not((t.state) in ((4), (5), (8)))) and
    ((t.id_mega) in (({2})))
  )
) t,
(
  select
    t.branchno as branchno
  from
    offcash.depolist t
  where
  (
    ((t.flowday) in ((to_date('{1}', 'DD.MM.YYYY')))) and
    ((t.division) in ((12))) and
    (not((t.state) in ((4), (5), (8)))) and
    ((t.id_mega) in (({2})))
  )
) r
where
(
  ((t.action) in ((0))) and
  ((t.lsttype) in (('{3}'))) and
  ((t.cntwrk) between (0) and ({4})) and
  (not(((t.lsttype) in (('�������(��������)'))) and ((t.branchno) in ((r.branchno)))))
)

select
  t.listid,
  t.state,
  0,
  t.restcount,
  t.state,
  {0}
from
(
  select
    t.id as listid,
    t.state as state,
    t.action as action,
    t.branchno as branchno,
    t.restcount as restcount,
    decode(t.division, 6, '��184(����������)', 12, '�������(����������)', 2, '�������(��������)', 3, '�190(��������)', 5, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'), 4, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)')) as lsttype,
    nvl(((sum(decode(t.action, 0, t.restcount, 0)) over(partition by decode(t.division, 6, '��184(����������)', 12, '�������(����������)', 2, '�������(��������)', 3, '�190(��������)', 5, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'), 4, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)')) order by decode(t.state, 0, decode(t.userlogin, '*', 0, 1), 1, 3, 3, 1, t.state) asc, t.opdaybegin asc, t.listtype asc, t.id asc)) + (sum(decode(t.action, 0, 0, t.restcount)) over())) / 1000, 0) as cntwrk
  from
    offcash.depolist t
  where
  (
    ((t.flowday) in ((to_date('{1}', 'DD.MM.YYYY')))) and
    ((t.division) in ((2), (3), (4), (5), (6), (12))) and
    (not((t.state) in ((4), (5), (8)))) and
    ((t.id_mega) in (({2})))
  )
) t,
(
  select
    t.branchno as branchno
  from
    offcash.depolist t
  where
  (
    ((t.flowday) in ((to_date('{1}', 'DD.MM.YYYY')))) and
    ((t.division) in ((12))) and
    (not((t.state) in ((4), (5), (8)))) and
    ((t.id_mega) in (({2})))
  )
) r
where
(
  ((t.action) in ((0))) and
  ((t.lsttype) in (('{3}'))) and
  ((t.cntwrk) between (0) and ({4})) and
  (not(((t.lsttype) in (('�������(��������)'))) and ((t.branchno) in ((r.branchno)))))
)

select
  r.LSTType as LSTType,
  nvl(t.CNTNew, '0 / 0') as CNTNew,
  nvl(t.CNTPartial, '0 / 0') as CNTPartial,
  nvl(t.CNTProcess, '0 / 0') as CNTProcess,
  nvl(t.CNTTerminate, '0 / 0') as CNTTerminate,
  nvl(t.WRKNormal, '0 / 0') as WRKNormal,
  nvl(t.WRKEnd, '0 / 0') as WRKEnd,
  nvl(t.WRKError, '0 / 0') as WRKError
from
(
  select
    decode(t.division, 6, '��184(����������)', 12, '�������(����������)', 2, '�������(��������)', 3, '�190(��������)', 5, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'), 4, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)')) as LSTType,
    sum(decode(t.state, 0, 1, 0)) || ' / ' || sum(decode(t.state, 0, t.restcount, 0)) as CNTNew,
    sum(decode(t.state, 1, 1, 0)) || ' / ' || sum(decode(t.state, 1, t.restcount, 0)) as CNTPartial,
    sum(decode(t.state, 2, 1, 0)) || ' / ' || sum(decode(t.state, 2, t.restcount, 0)) as CNTProcess,
    sum(decode(t.state, 3, 1, 0)) || ' / ' || sum(decode(t.state, 3, t.restcount, 0)) as CNTTerminate,
    sum(decode(t.action, 1, 1, 0)) || ' / ' || sum(decode(t.action, 1, t.restcount, 0)) as WRKNormal,
    sum(decode(t.action, 2, 1, 0)) || ' / ' || sum(decode(t.action, 2, t.restcount, 0)) as WRKEnd,
    sum(decode(t.action, 3, 1, 0)) || ' / ' || sum(decode(t.action, 3, t.restcount, 0)) as WRKError
  from
    offcash.depolist t
  where
  (
    ((t.flowday) in ((to_date('{0}', 'DD.MM.YYYY')))) and
    ((t.division) in ((2), (3), (4), (5), (6), (12))) and
    (not((t.state) in ((4), (5), (8)))) and
    ((t.id_mega) in (({1})))
  )
  group by
  (
    decode(t.division, 6, '��184(����������)', 12, '�������(����������)', 2, '�������(��������)', 3, '�190(��������)', 5, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'), 4, decode(t.flowday, t.opdaybegin, '�������.(new)', t.opdayend, '�������.(new)', '�������.(old)'))
  )
) t,
(
  select
    LSTType
  from
  (
    select
      '�������.(old)' as v1,
      '�������.(old)' as v2,
      '��184(����������)' as v3,
      '�������(����������)' as v4,
      '�������(��������)' as v5,
      '�190(��������)' as v6,
      '�������.(new)' as v7,
      '�������.(new)' as v8
    from
      dual
  )
  unpivot
  (
    LSTType for tp in (v1, v2, v3, v4, v5, v6, v7, v8)
  )
) r
where
(
  ((t.LSTType(+)) in ((r.LSTType)))
)
order by
  decode(r.LSTType, '�������.(old)', 1, '�������.(old)', 2, '��184(����������)', 3, '�������(����������)', 4, '�������(��������)', 5, '�190(��������)', 6, '�������.(new)', 7, '�������.(new)', 8) asc
