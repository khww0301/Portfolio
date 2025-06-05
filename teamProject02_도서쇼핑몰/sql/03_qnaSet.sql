-- 문의사항 30개 insert
begin
  for i in 1..30 loop
	  insert into qna (num, writer, title, content, email)
	  values (
	    i,
	    'user' || LPAD(i, 2, '0'),
	    '문의사항 ' || i || '번입니다.',
	    'user' || LPAD(i, 2, '0') || ' 고객님의 문의 내용입니다. 확인 부탁드립니다.',
	    'user' || LPAD(i, 2, '0') || '@test.com'
	  );
  end loop;
end;
/
commit;