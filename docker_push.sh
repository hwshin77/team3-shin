prefix="group1-team3"
app="accounts-service"
ver="0.2.18"

echo "docker build -t k8s-vga-worker1:5000/${prefix}-${app}:v${ver}"
#docker build -t k8s-vga-worker1:5000/${prefix}-${app}:v${ver} ./
docker push k8s-vga-worker1:5000/${prefix}-${app}:v${ver}