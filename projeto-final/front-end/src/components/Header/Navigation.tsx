import { Flex } from '@chakra-ui/react'
import { ItemNavigation } from './ItemNavigation'

export function Navigation () {
  const pages = [
    { text: 'Home', redirect: '/' },
    { text: 'Estantes', redirect: '/estantes' },
    { text: 'Dispositivos', redirect: '/dispositivos' },
    { text: 'Relatórios', redirect: 'http://localhost:3001', newPage: true },
    { text: 'Configurações', redirect: '/configuracoes' }
  ]

  return (
    <Flex
      as="nav"
      gap="32px"
      alignItems="center"
      height="100%"
    >
      { pages.map(({ text, redirect, newPage = false }, index) => (
        <ItemNavigation key={text + index}
          text={text}
          redirect={redirect}
          newPage={newPage}
        />
      ))}
    </Flex>
  )
}
