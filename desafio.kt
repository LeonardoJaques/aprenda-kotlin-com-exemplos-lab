// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String, val nivel: Nivel = Nivel.BASICO)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val curso: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }


    fun alocarConteudo(conteudo: ConteudoEducacional) {
        conteudos += conteudo

    }

    fun desalocarConteudo(conteudo: ConteudoEducacional) {
        conteudos -= conteudo
    }

    fun listarFormacao() {
        println("\tFormação: $curso")
    }

    fun listarFormacaoComConteudos() {
        println("\n\tFormação: $curso")
        println("\t\tConteúdos: ")
        conteudos.forEach() { println("\t\t\t$it") }

    }

    fun listarFormacaoComInscritos() {
        // nome do usuário
        val aluno = inscritos.map { it.nome  }
        val nivel = inscritos.map { it.nivel  }
        println("\tFormação: curso: $curso nome: ${aluno[0]} nivel: ${nivel[0]}")
    }
}

fun main() {

    // Criação de usuários
    val usuario1 = Usuario("João", "joao@email", Nivel.INTERMEDIARIO)
    val usuario2 = Usuario("Maria", "maria@email", Nivel.DIFICIL)
    val usuario3 = Usuario("José", "jose@email", Nivel.BASICO)

    // matricular usuários

    val formacao = Formacao("Kotlin", mutableListOf())
    formacao.matricular(usuario1)
    formacao.matricular(usuario1)
    formacao.matricular(usuario1)



    // Criação de conteúdos

       val cursos:MutableMap<String,List<ConteudoEducacional> > = HashMap()

        cursos["kotlin"] = listOf(
            ConteudoEducacional("Introdução ao Kotlin", 40, Nivel.BASICO),
            ConteudoEducacional("Desenvolvimento em Kotlin", 60, Nivel.INTERMEDIARIO),
            ConteudoEducacional("Deploy em Kotlin", 80, Nivel.DIFICIL)
        )
        cursos["java"] = listOf(
            ConteudoEducacional("Introdução ao Java", 40, Nivel.BASICO),
            ConteudoEducacional("Desenvolvimento em Java", 60, Nivel.INTERMEDIARIO),
            ConteudoEducacional("Deploy em Java", 80, Nivel.DIFICIL)
        )
        cursos["python"] = listOf(
            ConteudoEducacional("Introdução ao Python", 40, Nivel.BASICO),
            ConteudoEducacional("Desenvolvimento em Python", 60, Nivel.INTERMEDIARIO),
            ConteudoEducacional("Deploy em Python", 80, Nivel.DIFICIL)
        )

        val kotlin = cursos["kotlin"]
        val java = cursos["java"]
        val python = cursos["python"]

    // Criação de formações
    val formacao1 = Formacao("Kotlin", kotlin!!)
    val formacao2 = Formacao("Java", java!! )
    val formacao3 = Formacao("Python", python!!)

    // Matricular usuários
    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao3.matricular(usuario3)

    //  Alocar formações
    formacao1.alocarConteudo(kotlin[0])
    formacao2.alocarConteudo(java[1])
    formacao3.alocarConteudo(python[2])

    //  Listar formações
    println("Lista de formações:")
    formacao1.listarFormacao()
    formacao2.listarFormacao()
    formacao3.listarFormacao()

    // Listar conteúdos
    println("\nLista de conteúdos:")
    formacao1.listarFormacaoComConteudos()
    formacao2.listarFormacaoComConteudos()
    formacao3.listarFormacaoComConteudos()

    // Listar inscritos
    println("\nLista de inscritos:")
    formacao1.listarFormacaoComInscritos()
    formacao2.listarFormacaoComInscritos()
    formacao3.listarFormacaoComInscritos()

    // Desmatricular usuários
    formacao1.desalocarConteudo(kotlin[0])
    formacao2.desalocarConteudo(java[1])
    formacao3.desalocarConteudo(python[2])

    // Listar formações após desmatricular
    println("\nLista de formações:")
    formacao1.listarFormacao()
    formacao2.listarFormacao()
    formacao3.listarFormacao()

    // Listar conteúdos após desmatricular
    println("\nLista de conteúdos:")
    formacao1.listarFormacaoComConteudos()
    formacao2.listarFormacaoComConteudos()
    formacao3.listarFormacaoComConteudos()

}