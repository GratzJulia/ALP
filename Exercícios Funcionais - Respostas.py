from functools import reduce

# Questão1:
NOTAS = [8.0, 7.0, 8.3, 9.0, 4.5, 6.0, 3.7, 5.0, 7.1, 9.5, 6.0]

def retornaString(n):
  if n>6:
    return "APROVADO"
  else:
    return "REPROVADO"

reduce_media = reduce(lambda nota,soma: (nota+soma), NOTAS, 0)
filter_notas = filter(lambda nota: nota>6, NOTAS)
map_string = map(lambda n: retornaString(n), NOTAS)

print("QUESTÃO 1:")
print(reduce_media/11)
print(list(filter_notas))
print(list(map_string))

# Questão2:
NOMES = ["Ben", "Jafar", "Matthews", "Priya", "Brian"]

map_nomes = map(lambda nome: "".join(reversed(nome)), NOMES)
map_qtdCaracteres = map(lambda x: len(list(x)), NOMES)
maiorNome = max(map_qtdCaracteres)
filter_maiorNome = filter(lambda x: len(list(x)) == maiorNome, NOMES)

print("\nQUESTÃO 2:")
print(list(map_nomes))
print(list(filter_maiorNome))

# Questão3:
LIVROS = [{"id": 70111470,"title": "Die Hard","rating": [4.0]},{"id": 654356453,"title": "Bad Boys","rating": [5.0]},{"id": 65432445,"title": "The Chamber","rating": [3.0]}]

def ratingMaiorOuIgual(x):
  for r in x['rating']:
    if r>=4:
      return x['title']

def objComposto(livro):
  for r in livro['rating']:
    if r>=4:
      livro.pop('rating')
      return livro

objetos = filter(lambda x: ratingMaiorOuIgual(x), LIVROS)
titulos = map(lambda t: t['title'], objetos)
objetosCompostos = map(objComposto, LIVROS)

print("\nQUESTÃO 3:")
print(list(titulos))
print(list(filter(lambda o: o!= None, objetosCompostos)))

# Questão4:
INFOS = [{ "label": "sala", "largura": 4.5, "comprimento":5 },{ "label": "quarto1", "largura": 3.5, "comprimento":2 },{ "label": "quarto2", "largura": 2.7, "comprimento":2 },{ "label": "banheiro" , "largura": 1.5, "comprimento":2 }]

maior_area = max(map(lambda a: a['largura'] * a['comprimento'], INFOS))
filter_maior_comodo = filter(lambda a: a['largura'] * a['comprimento'] == maior_area, INFOS)

area_comodos = map(lambda a: a['largura'] * a['comprimento'], INFOS)
area_total_apartamento = reduce(lambda c1, c2: c1 + c2, area_comodos, 0)

filter_quartos = filter(lambda i: not i['label'].find("quarto"), INFOS)
area_quartos = map(lambda aq: aq['largura'] * aq['comprimento'], filter_quartos)
area_total_quartos = reduce(lambda q1, q2: q1 + q2, area_quartos, 0)

print("\nQUESTÃO 4:")
print(list(filter_maior_comodo))
print(area_total_apartamento)
print(area_total_quartos)
