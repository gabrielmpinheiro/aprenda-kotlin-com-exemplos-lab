import java.lang.Exception

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

open class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()
    val report: List<Aluno> = inscritos

    fun matricular(usuario: Aluno) {
        //add ao final de inscritos
        if (inscritos.contains(usuario)){
            throw Exception("Usuário já está matriculado!")
        }

        if (nivel.equals(Nivel.AVANCADO)) {
            if(!usuario.nivel.equals(nivel)) {
                throw Exception("Apenas usuários nível avançado podem fazer formações Avançadas")
            }
        }

        inscritos.add(usuario)
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

data class Aluno(var nome: String, var nivel: Nivel) : Usuario()

fun main() {

    /* Criando Cadastrando cursos */
    var curso1 = ConteudoEducacional("PHP", 50)
    var curso2 = ConteudoEducacional("JAVA", 70)
    var curso3 = ConteudoEducacional("Spring", 40)
    var curso4 = ConteudoEducacional("HTML", 50)
    var curso5 = ConteudoEducacional("CSS", 70)
    var curso6 = ConteudoEducacional("Bootstrap", 40)
    var curso7 = ConteudoEducacional("Kotlin e Spring", 100)
    var curso8 = ConteudoEducacional("MongoDB", 80)
    var curso9 = ConteudoEducacional("Java Avançado", 120)

    /* Criando e adicionando os cursos às listas*/
    var conteudos = mutableListOf<ConteudoEducacional>()
    var novosConteudos = mutableListOf<ConteudoEducacional>()
    var conteudosAvancados = mutableListOf<ConteudoEducacional>()

    conteudos.add(curso1)
    conteudos.add(curso2)
    conteudos.add(curso3)
    novosConteudos.add(curso4)
    novosConteudos.add(curso5)
    novosConteudos.add(curso6)
    conteudosAvancados.add(curso7)
    conteudosAvancados.add(curso8)
    conteudosAvancados.add(curso9)

    /* Criando as formações com base nos conteúdos educacionais previamente criados */
    var formacao1 = Formacao("Formação Webmaster", conteudos, Nivel.INTERMEDIARIO)
    var formacao2 = Formacao("Formacao Webdesigner", novosConteudos, Nivel.INICIANTE)
    var formacao3 = Formacao("Formação Avançada", conteudosAvancados, Nivel.AVANCADO)

    /* Criando os alunos e cadastrando-os nos cursos*/
    var aluno1 = Aluno("Gabriel", Nivel.AVANCADO)
    var aluno2 = Aluno("Rafaela", Nivel.INTERMEDIARIO)
    var aluno3 = Aluno("Dinda", Nivel.INICIANTE)

    formacao1.matricular(aluno1)
    formacao1.matricular(aluno2)
    formacao1.matricular(aluno3)
    formacao2.matricular(aluno1)

    /* Pega todos os integrantes da primeira formação */
    println(formacao1.getInscritos())

    /* Pega todos os integrantes da segunda formação*/
    println(formacao2.getInscritos())

    /* Desmatricula um aluno de um curso */
    formacao1.desmatricular(aluno3)

    //A formação AVANCADO só vai permitir cadastrar alunos de nível avançado. Os demais aceitam alunos de qualquer nível.
    //Provoca uma exception
    formacao3.matricular(aluno3)

    /* provoca uma Exception: Tenta cadastrar novamente um aluno já cadastrado na formação */
    formacao1.matricular(aluno1)

}
