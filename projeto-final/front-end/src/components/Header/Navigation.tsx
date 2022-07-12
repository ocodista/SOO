import { Flex } from '@chakra-ui/react'
import { ItemNavigation } from './ItemNavigation'

export function Navigation () {
  const pages = [
    { text: 'Estantes', redirect: '/estantes' },
    { text: 'Dispositivos', redirect: '/dispositivos' },
    { text: 'Relatórios', redirect: '/relatorios' },
    { text: 'Configurações', redirect: '/configuracoes' }
  ]

  return (
    <Flex
      as="nav"
      gap="32px"
      alignItems="center"
      height="100%"
    >
      { pages.map(({ text, redirect }, index) => (
        <ItemNavigation key={text + index} text={text} redirect={redirect} />
      ))}
    </Flex>
  )
}
