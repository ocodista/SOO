import type { AppProps } from 'next/app'
import { ChakraProvider } from '@chakra-ui/react'

import '../styles/globals.css'

function MyApp ({ Component, pageProps }: AppProps) {
  return (
    <ChakraProvider>
      <main>
        <Component {...pageProps} />
      </main>
    </ChakraProvider>
  )
}

export default MyApp
