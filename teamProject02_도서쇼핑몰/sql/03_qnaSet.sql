-- ���ǻ��� 30�� insert
begin
  for i in 1..30 loop
	  insert into qna (num, writer, title, content, email)
	  values (
	    i,
	    'user' || LPAD(i, 2, '0'),
	    '���ǻ��� ' || i || '���Դϴ�.',
	    'user' || LPAD(i, 2, '0') || ' ������ ���� �����Դϴ�. Ȯ�� ��Ź�帳�ϴ�.',
	    'user' || LPAD(i, 2, '0') || '@test.com'
	  );
  end loop;
end;
/
commit;