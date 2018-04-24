class CodeInterpret {
	int interpret (ArvoreSintatica arv) {
		if (arv instanceof Mult)
			return (interpret ( ((Mult) arv).arg1 ) *
							interpret ( ((Mult) arv).arg2 )
							);
		if (arv instanceof Soma)
			return (interpret ( ((Soma) arv).arg1 ) +
							interpret ( ((Soma) arv).arg2 )
							);
		if (arv instanceof Sub )
			return (interpret ( ((Sub ) arv).arg1 ) -
							interpret ( ((Sub ) arv).arg2 )
							);
		if (arv instanceof Div )
			return (interpret ( ((Div ) arv).arg1 ) /
							interpret ( ((Div ) arv).arg2 )
							);

		if (arv instanceof Num)
			return ((Num) arv).num;

		return 0;
	}
}
