package programacaocomaspectos;

public aspect Aspect {
	pointcut exemplo_pointcut() : call(* Teste.testar());
	
	before() : exemplo_pointcut() {
		System.out.println("--Before testar()--");
	}
	
	void around() : exemplo_pointcut() {
		System.out.println("-- Sobrescrevi! --");
	}
	
	after() : exemplo_pointcut() {
		System.out.println("--After testar()--");
	}
}
