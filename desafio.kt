// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)


enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
enum class TipoUsuario { ALUNO, PROFESSOR }

data class Usuario(var nome: String, var email: String, var tipoUsuario: TipoUsuario = TipoUsuario.ALUNO)

data class ConteudoEducacional(val nome: String, val professor:Usuario, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuarios: List<Usuario>) {
        usuarios.forEach { inscritos.add(it) }
    }

    fun mostrarConteudos() {
        for (conteudo in this.conteudos){
            println("${conteudo.nome} está sendo minstrado pelo professor ${conteudo.professor.nome} possuindo um total de ${conteudo.duracao} horas");
        }
    }

    fun mostrarInscritos() {
        inscritos.forEach { println("${it.nome} está inscrito em ${this.nome}")  }
    }
}

fun main() {
    val aluno1 = Usuario("estudante1", "estudante1@gmail.com", TipoUsuario.ALUNO)
    val aluno2 = Usuario("estudante2", "estudante2@gmail.com", TipoUsuario.ALUNO)
    val aluno3 = Usuario("estudante3", "estudante3@gmail.com", TipoUsuario.ALUNO)
    val professor1 = Usuario("professor1", "professor1@gmail.com", TipoUsuario.PROFESSOR)
    val professor2 = Usuario("professor2", "professor2@gmail.com", TipoUsuario.PROFESSOR)

    val listaConteudosEducacionais: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução ao Desenvolvimento Moderno de Software", professor2,5),
        ConteudoEducacional("Orientação a Objetos - POO",professor1, 12),
        ConteudoEducacional("Fundamentos do docker", professor1, 8)
    )

    val formacao = Formacao("Introdução ao Desenvolvimento Moderno de Software", listaConteudosEducacionais, Nivel.BASICO)
    val formacao2 = Formacao("Orientação a Objetos - POO", listaConteudosEducacionais, Nivel.INTERMEDIARIO)

    listaConteudosEducacionais.run {
        formacao2.matricular(listOf(aluno1, aluno2))
        formacao.matricular(listOf(aluno2,aluno3 ))
        formacao.matricular(listOf(professor1))
    }

    formacao.mostrarConteudos()

    println("\nOs seguintes alunos estão inscritos:")
    formacao.mostrarInscritos()

}
