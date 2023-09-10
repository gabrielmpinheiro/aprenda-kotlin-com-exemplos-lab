import java.lang.Exception

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

open class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    val report: List<Aluno> = inscritos

    fun matricular(usuario: Aluno) {
        //add ao final de inscritos
        if (inscritos.contains(usuario)){
            throw Exception("Usuário já está matriculado!")
        } else {
            inscritos.add(usuario)
        }

    }

    fun desmatricular(usuario: Aluno){
        //busca o aluno dentro de inscritos, e se encontrar, o remove
        if (inscritos.contains(usuario)){
            inscritos.remove(usuario)
        }
    }

    fun getInscritos(){
        println("Usuarios cadastrados na formação $nome :")
        println(report)
    }
}

data class Aluno(var nome: String) : Usuario()

fun main() {

    var curso1 = ConteudoEducacional("PHP", 50)
    var curso2 = ConteudoEducacional("JAVA", 70)
    var curso3 = ConteudoEducacional("Spring", 40)

    var curso4 = ConteudoEducacional("HTML", 50)
    var curso5 = ConteudoEducacional("CSS", 70)
    var curso6 = ConteudoEducacional("Bootstrap", 40)

    var conteudos = mutableListOf<ConteudoEducacional>()

    conteudos.add(curso1)
    conteudos.add(curso2)
    conteudos.add(curso3)

    var novosConteudos = mutableListOf<ConteudoEducacional>()

    novosConteudos.add(curso4)
    novosConteudos.add(curso5)
    novosConteudos.add(curso6)

    var formacao1 = Formacao("Formação Webmaster", conteudos)
    var formacao2 = Formacao("Formacao Webdesigner", novosConteudos)

    var aluno1 = Aluno("Gabriel")
    var aluno2 = Aluno("Rafaela")
    var aluno3 = Aluno("Dinda")

    formacao1.matricular(aluno1)
    formacao1.matricular(aluno2)
    formacao1.matricular(aluno3)

    formacao2.matricular(aluno1)

    println(formacao1.getInscritos())
    println(formacao2.getInscritos())

    formacao1.desmatricular(aluno3)

    println("=========================")
    println(formacao1.getInscritos())

    //formacao1.matricular(aluno1)

}
