// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

open class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(usuario: Aluno) {
        //add ao final de inscritos
        inscritos.add(usuario)
    }

    fun getInscritos(){
        println(inscritos)
    }
}

data class Aluno(var nome: String) : Usuario()

fun main() {

    var curso1 = ConteudoEducacional("PHP", 50)
    var curso2 = ConteudoEducacional("JAVA", 70)
    var curso3 = ConteudoEducacional("Spring", 40)

    var conteudos = mutableListOf<ConteudoEducacional>()

    conteudos.add(curso1)
    conteudos.add(curso2)
    conteudos.add(curso3)

    var formacao1 = Formacao("Formação Webmaster", conteudos)

    var aluno1 = Aluno("Gabriel")
    var aluno2 = Aluno("Rafaela")
    var aluno3 = Aluno("Dinda")
    formacao1.matricular(aluno1)
    formacao1.matricular(aluno2)
    formacao1.matricular(aluno3)

    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    println(formacao1.getInscritos())

}
