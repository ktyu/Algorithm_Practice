while(True):
    str = input().strip()

    if str == 'EOI':
        break
    
    str = str.lower()
    
    try:
        a = str.index('nemo')
    except Exception as e:
        print('Missing')
        continue
        
    print('Found')
    